package com.hotfoot.rapid.ai.document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tika.Tika;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet(name = "uploadfile", urlPatterns = { "/uploadfile" }, asyncSupported = true)
public class UploadFile extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String UPLOAD_DIRECTORY = "/home/vagrant/image";
	private String LOCAL_DIRECTORY = "/home/vagrant/image";
	private List<String> permittedContentTypes;
	private ObjectMapper mapper = new ObjectMapper();
	private Tika tika = new Tika();
	private boolean localUpload;
	public UploadFile(String rootPath) {
		UPLOAD_DIRECTORY = rootPath;
	}

	public UploadFile(String rootPath, List<String> permittedContentTypes, boolean localUpload, String localPath) {
		this(rootPath);
		this.localUpload = localUpload;
		this.LOCAL_DIRECTORY = localPath;
		setPermittedContentTypes(permittedContentTypes);
//		this.auCommonUrl = auCommonUrl;
//		this.imageCompress = imageCompress;
//		this.webUserAgent = webUserAgent;

	}

	private void setPermittedContentTypes(List<String> permittedContentTypes) {
		if (permittedContentTypes != null) {
			this.permittedContentTypes = new ArrayList<>();
			for (String permittedContentType : permittedContentTypes) {
				final String trimmed = permittedContentType.trim();
				if (!trimmed.isEmpty()) {
					this.permittedContentTypes.add(trimmed);
				}
			}
		}
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.doOptions(arg0, arg1);
		arg1.addHeader("Access-Control-Allow-Origin", "*");
	}

	private String getValue(String name, List<FileItem> multiparts) {
		for (FileItem item : multiparts) {

			if (name.equals(item.getFieldName())) {
				return item.getString();
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		response.addHeader("Access-Control-Allow-Origin", "*");
		// process only if it is multipart content
		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 20);// 20MB
			try {
				// Parse the request
				// Map<String, List<FileItem>> parameterMap =
				// upload.parseParameterMap(request);

				List<FileItem> multiparts = upload.parseRequest(request);
				String id = getValue("id", multiparts);
				id = (id != null ? (id + "_") : "") + UUID.randomUUID().toString();
				// Files.probeContentType()
				response.setContentType("application/json");
				response.setHeader("Cache-Control", "no-cache");

				List<String> errors = new ArrayList<>();
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						String extension = name.substring(name.lastIndexOf("."));
						if ((".jfif").equalsIgnoreCase(extension)) {
							errors.add("Invalid file type");
						}
						final String mimetype = tika.detect(item.getInputStream());
						if (permittedContentTypes != null && !permittedContentTypes.contains(mimetype)) {
							final String msg = "Invalid file type - " + name;
							errors.add(msg);
						}
					}
				}
				if (errors.isEmpty()) {
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String name = new File(item.getName()).getName();
							processIncomingFile(request, response, id, item, name);
						} else {
//						System.out.println(item.getFieldName() + "___" + item.getString());
						}
					}
				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("{\"errors\": " + mapper.writeValueAsString(errors) + "}");
				}

			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"error\": \"" + "Error Saving File" + "\"}");
			}

		}
	}

	private void processIncomingFile(HttpServletRequest request, HttpServletResponse response, String id, FileItem item, String name) throws Exception {
		String product = request.getParameter("X-AUTH-PRODUCT");
		if (product == null) {
			product = request.getHeader("X-AUTH-PRODUCT");
		}
		String productName = "";
		if (product != null) {
			productName = product; // use the product as the name of the directory
		}
		String extension = name.substring(name.lastIndexOf("."));
		String actualName = name.substring(0, name.lastIndexOf("."));
		Path fileName = Paths.get(UPLOAD_DIRECTORY, productName, actualName + "_-_" + id + extension);
		uploadFile(response, id, item, extension, actualName, fileName);
		if (localUpload) {
			Path fileNameLocal = Paths.get(LOCAL_DIRECTORY, productName, actualName + "_-_" + id + extension);
			Files.copy(fileName, fileNameLocal, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	private void uploadFile(HttpServletResponse response, String id, FileItem item, String extension, String actualName, Path fileName) throws Exception, IOException {
		item.write(fileName.toFile());
		Map<String, String> fileJson = new HashMap<String, String>();
		fileJson.put("filereference", String.valueOf(JsonStringEncoder.getInstance().quoteAsString(actualName + "_-_" + id + extension)));
		fileJson.put("image_path", fileName.toString());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(fileJson);
		response.getWriter().write(json);
	}

}
