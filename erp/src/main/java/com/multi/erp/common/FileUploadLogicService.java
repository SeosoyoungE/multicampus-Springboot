package com.multi.erp.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.erp.DTO.BoardFileDTO;
import com.multi.erp.DTO.MemberDTO;

@Service
public class FileUploadLogicService {
	//파일업로드를 수행하는 메소드 - 업로드된 파일의 정보를 BoardFileDTO로 변환해서 리턴
	//여러 개인 경우 BoaedFileDTO를 List에 담아서 리턴 
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFiles, String path) throws IllegalStateException, IOException {
		List<BoardFileDTO> filedtolist=new ArrayList<BoardFileDTO>();
		int count=1;
		for (MultipartFile multipartFile : multipartFiles) {
			// 업로드를 하는 경우 원본파일명과 서버에서 식별할 수 있는 실제 서버에 저장되는 파일명 두 개를 관리
			// 클라이언트가 업로드한 원본파일명
			if (!multipartFile.isEmpty()) {
				String originalFilename = multipartFile.getOriginalFilename();
				// 서버에서 식별할 수 있도록 파일명을 변경
				String storeFilename = createStoreFilename(originalFilename);
				//파일명과 path를 이용해서 실제 file객체를 만든 후 업로드하기
				//XXXXX/WEB-INF/upload +/+ 파일명
				multipartFile.transferTo(new File(path+File.separator+storeFilename));
				filedtolist.add(new BoardFileDTO(null,originalFilename,storeFilename,count+""));
				count++;
				
			}
		}
		return filedtolist;
	}

	private String createStoreFilename(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(pos + 1);// 시작index만 지정하면 끝까지 문자열 추출
		String uuid = UUID.randomUUID().toString(); // 파일확장자
		return uuid + "." + ext;
		
	}
	
	public MemberDTO uploadFile(MultipartFile multipartFile,String path, MemberDTO member) throws IllegalStateException, IOException {
		//경로와 파일을 set해줘야함
		if (!multipartFile.isEmpty()) {
			String originalFilename = multipartFile.getOriginalFilename(); //file의 오리지널 이름
			String storeFilename = createStoreFilename(originalFilename); //dto에 저장할 저장이름
			multipartFile.transferTo(new File(path+File.separator+storeFilename)); //오리지널 파일이름으로 저장
			member.setProfile_photo(storeFilename);
		}
		return member;
	}
}
