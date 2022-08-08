package college;

import java.util.Scanner;

public class book 
{
	 public int sNo;
	 public String bookName;
	 public String authorName;
	 public int bookQty;
	 
	 Scanner input = new Scanner(System.in);

	 public book()
	 {
		 System.out.println("Enter Serial No of Book:");
	     this.sNo = input.nextInt();
	     input.nextLine();
	  
	     System.out.println("Enter Book Name:");
	     this.bookName = input.nextLine();
	  
	     System.out.println("Enter Author Name:");
	     this.authorName = input.nextLine();
	  
	     System.out.println("Enter Quantity of Books:");
	     this.bookQty = input.nextInt();
	     
	 }
}

class books 
{
	book theBooks[] = new book[50];
	public static int count;
	Scanner input = new Scanner(System.in);

// Method 1	
	 public void addBook(book b)
	 {
		 for (int i = 0; i < count; i++) 
		 {
			 if (this.compareBookObjects(b, this.theBooks[i]) == 0)
				 
	             return;
		 }
		 if (count < 50)
		 {
			 theBooks[count] = b;
	         count++;
	     }
	     else 
	     {
	    	 System.out.println("No Space to Add More Books.");
	     }
	 }
// Method 2	 
 
	public int compareBookObjects(book b1, book b2)
	{
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) 
		{
			System.out.println("Book of this Name Already Exists.");
		 
			return 0;
		}
	 
		if (b1.sNo == b2.sNo) 
		{
			System.out.println("Book of this Serial No Already Exists.");

			return 0;
		}
		return 1;
 }
// Method 3
	
	public void searchBySno()
	{
		System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
		int sNo;
		System.out.println("Enter Serial No of Book:");
		sNo = input.nextInt();

		int flag = 0;
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty");
		
			for (int i = 0; i < count; i++) 
			{
				if (sNo == theBooks[i].sNo) 
				{
					System.out.println(
							theBooks[i].sNo + "\t\t"
						    + theBooks[i].bookName + "\t\t"
						    + theBooks[i].authorName + "\t\t"
						    + theBooks[i].bookQty);
					flag++;
					return;
				}
			}
			if (flag == 0)
				System.out.println("No Book for Serial No "+ sNo + " Found.");
	}
 // Method 4
 
	public void searchByAuthorName()
	{
		System.out.println("SEARCH BY AUTHOR'S NAME");
//		input.nextLine();
		System.out.println("Enter Author Name:");
		String authorName = input.nextLine();
		int flag = 0;
     
		System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty");

		for (int i = 0; i < count; i++)
		{ // if author matches any of its book
			if (authorName.equalsIgnoreCase(theBooks[i].authorName))
			{
				System.out.println(
						theBooks[i].sNo + "\t\t"
					    + theBooks[i].bookName + "\t\t"
					    + theBooks[i].authorName + "\t\t"
					    + theBooks[i].bookQty);
    		 		flag++;
			}
		} // Else no book matches for author 
		if (flag == 0)
			System.out.println("No Books of " + authorName + " Found.");
	}
// Method 5
 // To display all books
	public void showAllBooks()
	{
		System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
		System.out.println( "S.No\t\tName\t\tAuthor\t\tAvailable Qty");

		for (int i = 0; i < count; i++) 
		{
			System.out.println(
					theBooks[i].sNo + "\t\t"
                    + theBooks[i].bookName + "\t\t"
                    + theBooks[i].authorName + "\t\t"
                    + theBooks[i].bookQty);
		}
	}
// Method 6
// To edit the book
	public void upgradeBookQty()
	{
		System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
		System.out.println("Enter Serial No of Book");

		int sNo = input.nextInt();

		for (int i = 0; i < count; i++) 
		{
			if (sNo == theBooks[i].sNo)
			{
				System.out.println("Enter No of Books to be Added:");
				int addingQty = input.nextInt();
				theBooks[i].bookQty += addingQty;
			return;
			}
		}
	}
 
//Method 8
// To search the library
	public int isAvailable(int sNo)
	{
		for (int i = 0; i < count; i++) 
		{
			if (sNo == theBooks[i].sNo) 
			{
				if (theBooks[i].bookQty > 0)
				{
					System.out.println("Book is Available.");
					return i;
				}
				System.out.println("Book is Unavailable");
				return -1;
			}
		}
		System.out.println("No Book of Serial Number " + " Available in Library.");
		return -1;
	}
// Method 9
// To remove the book from the library
	public book checkOutBook()
	{
		System.out.println("Enter Serial No of Book to be Checked Out.");
		int sNo = input.nextInt();
		int bookIndex = isAvailable(sNo);

		if (bookIndex != -1) 
		{
			theBooks[bookIndex].bookQty--;
			return theBooks[bookIndex];
		}
		return null;
	}
// Method 10
// To add the Book to the Library
	public void checkInBook(book b)
	{
		for (int i = 0; i < count; i++) 
		{
			if (b.equals(theBooks[i])) 
			{
				theBooks[i].bookQty++;
				return;
			}
		}
	}
}


