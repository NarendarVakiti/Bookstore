package com.bookstore.bean;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * This bean for hold playload information of book and author details
 * @author nvakiti
 *
 */

@Getter @Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class BookDetails implements Serializable{

	private static final long serialVersionUID = -1450252897638356990L;

	private int bookId;
	private String bookName;
	private double bookPrice;
	private boolean availability;
	private String level;
	private String rating;
	private LocalDate publishedDate;
	private String authorName;
	private String addedBy;

}
