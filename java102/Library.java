package java102;

public class Library {
    public class LibraryItem {
        public final String title;
        public final String itemId;
        
        protected boolean isCheckedOut = false;
    
        public LibraryItem(String title, String itemId) {
            this.title = title;
            this.itemId = itemId;
        }
    
        public boolean available() {
            return !isCheckedOut;
        }
    
        public void checkOut() {
            isCheckedOut = true;
        }
    
        public void returnItem() {
            isCheckedOut = false;
        }
        public class Book extends LibraryItem {
            public final String author;
            public final int pageCount;
        
            public Book(String title, String itemId, String author, int pageCount) {
                super(title, itemId);
                this.author = author;
                this.pageCount = pageCount;
            }
        
            @Override
            public String toString() {
                return "Book: " + title + " by " + author + ", " + 
                        pageCount + " pages";
            }
        }
        public class DVD extends LibraryItem {
            public final double runtime;
        
            public DVD(String title, String itemId, double runtime) {
                super(title, itemId);
                this.runtime = runtime;
            }
        
            @Override
            public String toString() {
                return "DVD: " + title + ", Runtime: " + runtime + " minutes";
            }
        }
    }
}
