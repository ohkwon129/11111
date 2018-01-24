package com.ohhoonim.common.web;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ohhoonim.jiutopia.service.EventService;
import com.ohhoonim.jiutopia.service.FileTableService;
import com.ohhoonim.vo.FileTableVo;

@Controller
public class FileUpDownController {
	/*
	@RequestMapping(value = "/imageFileControl.do")
	public String imageFileControl() {

		return "/exam/imageFileControl";

	}
	 */
	
	@Resource(name="fileTableService")
	FileTableService fileTableService;
	
	@RequestMapping(value = "/common/imageFileUpload.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public HashMap<String, Object> image(MultipartHttpServletRequest request, @RequestParam HashMap<String, String> req) throws Exception {
		MultipartFile file = request.getFile("file");
		HashMap<String, Object> result = new HashMap<String, Object>();
		String files = req.get("eventeventTitle") == null ? "" : req.get("eventeventTitle");
		//String ex = request.getAttribute("file").toString() == null ? "" : request.getAttribute("file").toString();
		System.out.println(file);
		System.out.println("xx");
		String name = file.getName();
		String fileName = file.getOriginalFilename();
		String contentType = file.getContentType();
		String uploadedFileName = System.currentTimeMillis() + UUID.randomUUID().toString()
				+ fileName.substring(fileName.lastIndexOf("."));
		String uploadPath = "/upload";

		if (file.getSize() != 0) {
			file.transferTo(new File(uploadPath + "/" + uploadedFileName));
		}

		////////////////////////////////////////////////////////////////
		
		String downlink = request.getContextPath() + "/common/image.do?of=" + URLEncoder.encode(fileName, "UTF-8") + "&f="
				+ URLEncoder.encode(uploadedFileName, "UTF-8");

		////////////////////////////////////////////////////////////////
		
		FileTableVo vo = new FileTableVo();
		vo.setFileNm(fileName);
		vo.setUploadedNm(uploadedFileName);
		vo.setFileSize(file.getSize()+"");
		vo.setFileType(contentType);
		vo.setFileLink(downlink);
		
		// file table 에 정보를 저장. fileService....id를 가져와야함. !!
		//Map<String, Object> list = fileTableService.fileList(vo);
	//	int idCnt = (int)list.get("listCount");
		//String idCntStr = String.format("%012d", idCnt+1);
		//String fileId = "FILE"+idCntStr; 
		
		vo.setFileId("fileId");
		
		// fileTableService.addFiles(vo);
		System.out.println(vo.getFileNm());
		System.out.println(files);
		System.out.println(vo.getFileId());
		System.out.println(vo.getFileLink());
		System.out.println(vo.getUploadedNm());
		System.out.println(vo.getFileSize());
		System.out.println(vo.getFileType());
		System.out.println(file);
		
		result.put("file", vo);
		System.out.println(result);
		
		System.out.println(result.get("fileNm"));
		return result;
	}

	@RequestMapping("/common/image.do")
	public void fileDownload2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String f = request.getParameter("f"); // 저장된 파일이름
		String of = request.getParameter("of");// 원래 파일이름
		of = new String(of.getBytes("ISO8859_1"), "UTF-8");

		String path = "/upload";
		String fullPath = path + "/" + f;
		File downloadFile = new File(fullPath);

		response.setContentLength((int) downloadFile.length());

		// 다운로드 창을 띄우기 위한 헤더 조작
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(of.getBytes(), "ISO8859_1"));

		response.setHeader("Content-Transfer-Encoding", "binary");

		FileInputStream fin = new FileInputStream(downloadFile);
		ServletOutputStream sout = response.getOutputStream();

		byte[] buf = new byte[1024];
		int size = -1;

		while ((size = fin.read(buf, 0, buf.length)) != -1) {
			sout.write(buf, 0, size);
		}
		fin.close();
		sout.close();

	}
}
