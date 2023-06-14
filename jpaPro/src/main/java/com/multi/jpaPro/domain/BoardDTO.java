package com.multi.jpaPro.domain;

import java.sql.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "tbboard")
public class BoardDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String boardNo;
	String id;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
//	@UpdateTimestamp
	@CreationTimestamp
	Date write_date;
	String title;
	String content;
	@Column(name = "category")
	String category;
	public BoardDTO() {	
	}
	public BoardDTO(String boardNo, String id, Date write_date, String title, String content, String category) {
		super();
		this.boardNo = boardNo;
		this.id = id;
		this.write_date = write_date;
		this.title = title;
		this.content = content;
		this.category = category;
	}
	

	
	public BoardDTO(String boardNo, String id, Date write_date, String title, String content, String category,
			List<MultipartFile> files) {
		super();
		this.boardNo = boardNo;
		this.id = id;
		this.write_date = write_date;
		this.title = title;
		this.content = content;
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", id=" + id + ", write_date=" + write_date + ", title=" + title
				+ ", content=" + content + ", category=" + category + ", files="  + "]";
	}
	

	public void setFiles(List<MultipartFile> files) {
		System.out.println("********************************************");
		
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getId() {
		System.out.println("getId()");
		return id;
	}
	public void setId(String id) {
		System.out.println("setId()");
		this.id = id;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
