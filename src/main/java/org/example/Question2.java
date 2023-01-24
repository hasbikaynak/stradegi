package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {
/*For each Guarantor, starting with the highest total guarantee amount:
a. Initialize a variable to keep track of the total amount of loans allocated to the Guarantor
b. For each loan:
i. Check if the loan is open and has not been allocated to another Guarantor
ii. Check if the Guarantor has enough available guarantee amount to cover the loan
iii. Check if the Guarantor's allocation of loans with the same credit grade does not exceed 25%
iv. If all conditions are met, allocate the loan to the Guarantor and update the total amount of loans allocated to the Guarantor
Output the final loan allocation and the percentage of loans allocated for each credit grade for each Guarantor.*/

/*This program uses a list to store the loan details, and a map to store the Guarantor details, it loops through each open loan and checks
if the guarantor is able to cover the outstanding amount and if the percentage of the loan allocated to the same credit grade is less than or equal to 25% ,
if so the loan is allocated to the guarantor, the program then prints the allocated loans and the percentage of loan allocated to each guarantor for each credit grade.

I did not handle cases such as handling empty loan list or guarantor list and also did not handle the cases where the loans can't be
allocated to any guarantors.*/


        /*I've separated the main logic into three separate methods: allocateLoans, printAllocatedLoans, and
         printGuarantorAllocationPercentage. This makes the code more readable and maintainable as the logic for each task is separated and easy to understand.
       */


        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan("Loan 1", 6000, 1000, "21-May-23", 2, "Open", ""));
        loans.add(new Loan("Loan 2", 20000, 2000, "31-Aug-21", 3, "Open", ""));
        loans.add(new Loan("Loan 3", 70000, 3000, "01-Jan-30", 2, "Open", ""));



        Map<String, Guarantor> guarantors = new HashMap<>();
        guarantors.put("G1", new Guarantor("Guarantor 1", "G1", 20000));
        guarantors.put("G2", new Guarantor("Guarantor 2", "G2", 50000));

        // Allocate the loans to the Guarantors
        allocateLoans(loans, guarantors);

        // Print the allocated loans
        printAllocatedLoans(loans);

        // Print the Guarantor's allocation percentage
        printGuarantorAllocationPercentage(guarantors);

    }



    private static void allocateLoans(List<Loan> loans, Map<String, Guarantor> guarantors) {
        for (Loan loan : loans) {
            if (loan.getStatus().equals("Open") && loan.getGuarantor().equals("")) {
                for (Guarantor guarantor : guarantors.values()) {
                    if (guarantor.getTotalGuaranteeAmount() > loan.getOutstandingAmount()
                            && guarantor.getCreditGradeAllocated(loan.getCreditGrade()) + loan.getOutstandingAmount() / loan.getLoanAmount() <= 0.25) {
                        loan.setGuarantor(guarantor.getId());
                        guarantor.addCreditGradeAllocated(loan.getCreditGrade(), loan.getOutstandingAmount() / loan.getLoanAmount());
                        guarantor.setTotalGuaranteeAmount(guarantor.getTotalGuaranteeAmount() - loan.getOutstandingAmount());
                        break;
                    }
                }
            }
        }
    }

    private static void printAllocatedLoans(List<Loan> loans) {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    private static void printGuarantorAllocationPercentage(Map<String, Guarantor> guarantors) {
        for (Guarantor guarantor : guarantors.values()) {
            System.out.println(guarantor.getName());
            for (Map.Entry<Integer, Double> entry : guarantor.getCreditGradeAllocated().entrySet()) {
                System.out.println("Loan Grade: " + entry.getKey() + " % Of Loan Allocated: " + entry.getValue() * 100);
            }
        }
    }

}

class Loan {
    private String loanId;
    private double loanAmount;
    private double outstandingAmount;
    private String maturityDate;
    private int creditGrade;
    private String status;
    private String guarantor;

    public Loan(String loanId, double loanAmount, double outstandingAmount, String maturityDate, int creditGrade, String status, String guarantor) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.outstandingAmount = outstandingAmount;
        this.maturityDate = maturityDate;
        this.creditGrade = creditGrade;
        this.status = status;
        this.guarantor = guarantor;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public int getCreditGrade() {
        return creditGrade;
    }

    public String getStatus() {
        return status;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    @Override
    public String toString() {
        return "Loan: " + loanId + " Loan Amount: " + loanAmount + " Outstanding Amount: " + outstandingAmount + " Maturity Date: " + maturityDate + " Credit Grade: " + creditGrade + " Status: " + status + " Guarantor: " + guarantor;
    }

}

class Guarantor {
    private String name;
    private String id;
    private double totalGuaranteeAmount;
    private Map<Integer, Double> creditGradeAllocated;

    public Guarantor(String name, String id, double totalGuaranteeAmount) {
        this.name = name;
        this.id = id;
        this.totalGuaranteeAmount = totalGuaranteeAmount;
        this.creditGradeAllocated = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getTotalGuaranteeAmount() {
        return totalGuaranteeAmount;
    }

    public void setTotalGuaranteeAmount(double totalGuaranteeAmount) {
        this.totalGuaranteeAmount = totalGuaranteeAmount;
    }

    public Map<Integer, Double> getCreditGradeAllocated() {
        return creditGradeAllocated;
    }

    public double getCreditGradeAllocated(int creditGrade) {
        return creditGradeAllocated.getOrDefault(creditGrade, 0.0);
    }

    public void addCreditGradeAllocated(int creditGrade, double allocated) {
        creditGradeAllocated.put(creditGrade, getCreditGradeAllocated(creditGrade) + allocated);
    }
}

