# PROBLEM 1: Count copies of "The Lost Tribe" book at branch "Sharpstown"
SELECT IFNULL(noOfCopies, 0) as count
FROM tbl_book_copies
    LEFT JOIN tbl_book
        ON tbl_book_copies.bookId = tbl_book.bookId
    LEFT JOIN tbl_library_branch
        ON tbl_book_copies.branchId = tbl_library_branch.branchId
WHERE tbl_book.title = "The Lost Tribe"
    AND tbl_library_branch.branchName = "Sharpstown";


# PROBLEM 2: Count copies of "The Lost Tribe" book at each branch
SELECT branchName, IFNULL(noOfCopies, 10) as count
FROM tbl_book_copies
    INNER JOIN tbl_book
        ON tbl_book_copies.bookId = tbl_book.bookId
    INNER JOIN tbl_library_branch
        ON tbl_book_copies.branchId = tbl_library_branch.branchId
WHERE tbl_book.title = "The Lost Tribe";


# PROBLEM 3: Name of all borrowers who have no books checked out
SELECT name
FROM tbl_borrower
LEFT JOIN tbl_book_loans tbl
    ON tbl_borrower.cardNo = tbl.cardNo
WHERE tbl.cardNo IS NULL;


# PROBLEM 4: Get book title, borrower's name and address for all book due today at Sharpstown
SELECT title, name, address
FROM tbl_book_loans
LEFT JOIN tbl_book
    ON tbl_book_loans.bookId = tbl_book.bookId
LEFT JOIN tbl_borrower
    ON tbl_book_loans.cardNo = tbl_borrower.cardNo
WHERE CAST(dueDate AS DATE) = CURRENT_DATE();


# PROBLEM 5: Total number of books loaned per branch
SELECT branchName as branch, COUNT(*) as count
FROM tbl_book_loans
LEFT JOIN tbl_library_branch
    ON tbl_book_loans.branchId = tbl_library_branch.branchId
GROUP BY tbl_library_branch.branchName;


# PROBLEM 6: Names, addresses, and number of books checked out for all borrowers with more than 5 books checked
SELECT * FROM (
    SELECT name, address, COUNT(*) as count
    FROM tbl_book_loans
    LEFT JOIN tbl_borrower
        ON tbl_book_loans.cardNo = tbl_borrower.cardNo
    GROUP BY tbl_book_loans.cardNo) AS tbl
WHERE count > 5;


# PROBLEM 7: Title and copy count of each book authored or co-authored by Stephen King from Central
SELECT title, IFNULL(noOfCopies,0) as count
FROM (SELECT title, bookId
    FROM tbl_book
    LEFT JOIN tbl_author
        ON tbl_book.authId = tbl_author.authorId
    WHERE authorName = "Stephen King") AS tbl
LEFT JOIN tbl_book_copies
    ON tbl.bookId = tbl_book_copies.bookId
WHERE branchId = (SELECT branchId
                  FROM tbl_library_branch
                  WHERE branchName = "Central");