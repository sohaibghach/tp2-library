
package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Copy> copies = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();

    public void registerBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerCopy(Copy copy) {
        copies.put(copy.getInventoryNumber(), copy);
    }

    public void registerMember(Member member) {
        members.put(member.getNumber(), member);
    }

    public Loan lend(String memberNumber, String inventoryNumber, LocalDate today) {

        Member member = members.get(memberNumber);
        Copy copy = copies.get(inventoryNumber);

        if (member == null || copy == null) {
            throw new IllegalArgumentException("Member or copy not found");
        }

        if (!copy.isAvailable()) {
            throw new IllegalStateException("Copy is not available");
        }

        int openLoans = 0;

        for (Loan loan : loans) {
            if (loan.getMember().getNumber().equals(memberNumber)
                    && loan.isOpen()) {
                openLoans++;
            }
        }

        if (openLoans >= 5) {
            throw new IllegalStateException("Member has reached the loan limit");
        }

        Loan loan = new Loan(member, copy, today);
        loans.add(loan);
        copy.setAvailable(false);

        return loan;
    }

    public void returnCopy(String inventoryNumber, LocalDate today) {

        Copy copy = copies.get(inventoryNumber);

        if (copy == null) {
            throw new IllegalArgumentException("Copy not found");
        }

        for (Loan loan : loans) {
            if (loan.getCopy().getInventoryNumber().equals(inventoryNumber)
                    && loan.isOpen()) {

                loan.setReturnDate(today);
                copy.setAvailable(true);
                return;
            }
        }

        throw new IllegalStateException("No open loan found for this copy");
    }

    // Search for books by title
    public List<Book> searchByTitle(String keyword) {

        List<Book> results = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }
}


