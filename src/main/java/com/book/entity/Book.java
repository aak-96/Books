package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long bid;
		
		private String title;
		
		private String author;
		
		private Double price;
		
		private String status;
		
		private String summary;

		//constructor
		public Book(Long bid, String title, String author, Double price, String status, String summary) {
			super();
			this.bid = bid;
			this.title = title;
			this.author = author;
			this.price = price;
			this.status = status;
			this.summary = summary;
		}

		//getter and setter
		public Long getBid() {
			return bid;
		}

		public void setBid(Long bid) {
			this.bid = bid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		@Override
		public String toString() {
			return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", price=" + price + ", status="
					+ status + ", summary=" + summary + "]";
		}

		
		
			
		
}
