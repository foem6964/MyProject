package kr.co.controller;

import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.util.Utils;

@Controller
public class UploadAjaxController {
	private String uploadPath = "C:" + File.separator + "upload";
	
	@ResponseBody
	@RequestMapping(value = "/testUpload", method = RequestMethod.POST)
	public void testUploadFile(HttpSession session) {
		//resources 폴더에 img 폴더 추가
		//각 mvd 핸들러 첫줄에 아래코드 추가
//		String uploadPath1 = session.getServletContext().getRealPath("/resources/img");
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile2", method = RequestMethod.POST)
	public String deletefile(String filename) {
		System.out.println(filename);
		filename.replace('/', File.separatorChar);
		System.out.println(filename);
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx+1);
		
		MediaType mType = Utils.getMediaType(format);
		if(mType != null) {
				String pre = filename.substring(0,12);
				String suf = filename.substring(14);
				String oriname = pre+suf;
				File orifile = new File(uploadPath+oriname);
				orifile.delete();
		}
		File f = new File(uploadPath+filename);
		f.delete();
		
		
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.DELETE)
	public String filedelete(@RequestBody Map<String, Object> map) throws UnsupportedEncodingException {
		String filename = (String) map.get("filename");
		System.out.println(filename);
		filename = new String(URLDecoder.decode(filename,"UTF-8"));
		System.out.println(filename);
		Utils.deletefile(uploadPath, filename);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename) throws IOException {
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			String format = Utils.getFormat(filename);
			MediaType mType = Utils.getMediaType(format);
			
			in = new FileInputStream(uploadPath + filename);
			if (mType != null) {
				headers.setContentType(mType);
			} else {
				String originalName = Utils.getCutLastUnderBar(filename);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
							"attachment;filename=\"" + 
							new String(originalName.getBytes("UTF-8"), "ISO-8859-1"));
				
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
					headers, 
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadajax",
					method = RequestMethod.POST,
					produces = "text/plain;charset=utf-8")
	public String uploadajax(MultipartHttpServletRequest request) throws IOException {
		MultipartFile file = request.getFile("file");
		// saveFile 원본파일, thumbnail파일 2개저장 thumbnail 파일명엔 S_가 붙는다.
		String saveFileName = Utils.saveFile(file, uploadPath);
		return saveFileName;
	}

	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
		
	}
}
