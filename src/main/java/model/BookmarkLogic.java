package model;

import dao.BookmarkDAO;

public class BookmarkLogic {
	public boolean exequte(String examID,String userID) {
		BookmarkDAO bookmarkDAO = new BookmarkDAO();
		boolean result = false;
		
		if(examID != null) {
			if(bookmarkDAO.isBookmark(examID, userID)){
				result = bookmarkDAO.deleteBookmark(examID, userID);
			}else {
				result = bookmarkDAO.setBookmark(examID, userID);
			}
		}
		
		return result;
	}
}
