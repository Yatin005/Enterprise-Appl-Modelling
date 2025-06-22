package model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String publisherId;
	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPublisherId() {
		// TODO Auto-generated method stub
		return null;
	}
}