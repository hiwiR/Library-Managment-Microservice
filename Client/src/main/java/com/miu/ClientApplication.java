package com.miu;

import com.miu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.awt.geom.RectangularShape;
import java.util.List;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
	@Autowired
	RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**********************************************Inserting customer-1*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/customer",new Customer(
				3,"Melen","Birhanu",
				new Contact("hiwot.alemayehu@miu.edu","+1-202-913-8282"),
				new Address("1000N 4th street","Fairfield","52557")

		));
		System.out.println("**********************************************Inserting customer-2*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/customer",new Customer(
			4	,"Samuel","Bekeri",
				new Contact("hiwot.alemayehu@miu.edu","+1-202-913-8282"),
				new Address("1000N 4th street","Fairfield","52557")

		));

		System.out.println("**********************************************Inserting book-1*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/bookcommand", new BookDto(
				"002","The history of Tom Jones","Readers choice","Henery Fieding"
				));
		System.out.println("**********************************************Inserting book-2*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/bookcommand", new BookDto(
				"003","War and Peace","Readers choice","Tolstoy"
		));
		System.out.println("**********************************************Inserting Review-1*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/reviews", new ReviewDto(
				"002",5,"Melen Birhanu","Best book i have ever seen"
				));
		System.out.println("**********************************************Inserting Review-2*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/reviews", new ReviewDto(
				"002",4,"Samuel Bekri","Best book i have ever seen"
		));
		System.out.println("**********************************************Inserting Review-1*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/reviews", new ReviewDto(
				"003",4,"Melen Birhanu","Best book i have ever seen"
		));
		System.out.println("**********************************************Inserting Review-2*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/reviews", new ReviewDto(
				"003",5,"Samuel Bekri","Best book i have ever seen"
		));

		System.out.println("**********************************************Get Book Query*********************************************************  ");
		Books books = restTemplate.getForObject("http://localhost:8087/books",Books.class);
		if(books.getBooks().size() > 0){

			books.getBooks().forEach(bookQueryDto -> {
				System.out.println( "#############################################");
				System.out.println( "Isbn : " + bookQueryDto.getIsbn());
				System.out.println( "Title : " + bookQueryDto.getTitle());
				System.out.println( "Description :" + bookQueryDto.getDescription());
				System.out.println( "Author Name :" + bookQueryDto.getAuthorName());
			});
		}

		System.out.println("**********************************************Insert Borrowing-1*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/borrowings", new BorrowRequest(
			4,"003"

		));
		System.out.println("**********************************************Insert Borrowing-2*********************************************************  ");
		restTemplate.postForLocation("http://localhost:8087/borrowings", new BorrowRequest(
				4,"002"

		));
		System.out.println("**********************************************Put Book*********************************************************  ");
		restTemplate.put("http://localhost:8087/bookcommand", new BookDto(
						"002","updated title The history of Tom Jones","Readers choice","Henery Fieding"
				)
		);
		System.out.println("***********************************Get Updated Book information****************************************  ");
		BookQueryDto bookQueryDto = restTemplate.getForObject("http://localhost:8087/books/"+"002",BookQueryDto.class);
		if(bookQueryDto != null ){

				System.out.println( "#############################################");
				System.out.println( "Isbn : " + bookQueryDto.getIsbn());
				System.out.println( "Title : " + bookQueryDto.getTitle());
				System.out.println( "Description :" + bookQueryDto.getDescription());
				System.out.println( "Author Name :" + bookQueryDto.getAuthorName());

		}
		System.out.println("***********************************Get Updated Borrowing information****************************************  ");
		Borrowings borrowings = restTemplate.getForObject("http://localhost:8087/borrowing",Borrowings.class);
		if(borrowings.getBorrowingDto() != null ){
			borrowings.getBorrowingDto().stream().filter(borrowingDto -> borrowingDto.getIsbn().equals("002"))
							.forEach(borrowingDto -> {
				System.out.println( "#############################################");
				System.out.println( "Isbn : " + borrowingDto.getBorrowingNumber());
				System.out.println( "Isbn : " + borrowingDto.getIsbn());
				System.out.println( "Title : " + borrowingDto.getTitle());
				System.out.println( "Description :" + borrowingDto.getCustomername());
				System.out.println( "Author Name :" + borrowingDto.getDate());
			});
		}
	}
}
