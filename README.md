# CLI-Accounting-Ledger
Command line interface application to record financial transactions.
### Features: 
- Add deposits
- Make payments
- View ledger report 
  - Filter by current month, previous month, current year, previous year
  - Search for specific vendors
- Save records to csv file

### Screenshots

![home_menu.PNG](screenshots/home_menu.PNG)
![ledger_menu.PNG](screenshots/ledger_menu.PNG)
![reports_menu.PNG](screenshots/reports_menu.PNG)
![ledger_display.PNG](screenshots/ledger_display.PNG)

### Code highlight
```
  //Display Ledger Entries
  public static void displayLedger(String filter){
  sortLedger();
  
      String searchTerm = "empty";
  
      switch (filter){
          case "vendor":
              System.out.print("Please enter a vendor or depositor name to filter: ");
              searchTerm = read.nextLine();
      }
  
  
      System.out.printf(" %-12s| %-12s| %-30s| %-30s| %-12s\n", "Date", "Time", "Description", "Vendor", "Price");
      System.out.println("-------------|-------------|-------------------------------|-------------------------------|--------------------------");
  
      Boolean condition = true;
  
      int entriesFound = 0;
  
      LocalDateTime currentDateTime = LocalDateTime.now();
      Month currMonth = currentDateTime.getMonth();
      Month prevMonth = currentDateTime.getMonth().minus(1);
      int currYear = currentDateTime.getYear();
      int prevYear = currentDateTime.getYear() - 1;
      Month transactMonth;
      int transactYear;
  
      for ( Transaction t : transactionList){
          switch (filter){
              case "all":
                  break;
              case "deposit":
                  condition = t.getPrice() >= 0f;
                  break;
              case "payment":
                  condition = t.getPrice() <= 0f;
                  break;
              case "currMonth":
                  transactMonth = t.getDateTime().getMonth();
                  condition =  transactMonth == currMonth && t.getDateTime().isBefore(currentDateTime);
                  break;
              case "prevMonth":
                  transactMonth = t.getDateTime().getMonth();
                  LocalDateTime lastMonth = currentDateTime.minusMonths(1);
                  condition =  transactMonth == prevMonth && t.getDateTime().getYear() == lastMonth.getYear();
                  break;
              case "currYear":
                  transactYear = t.getDateTime().getYear();
                  condition = currYear == transactYear;
                  break;
              case "prevYear":
                  transactYear = t.getDateTime().getYear();
                  condition = currYear - 1 == transactYear;
                  break;
              case "vendor":
                  condition = t.getVendor().toLowerCase().contains(searchTerm.toLowerCase());
                  break;
              case "custom":
                  break;
          }
  
          if (condition) {
              t.displayTransaction();
              entriesFound++;
          }
      }
  
      System.out.printf("\n%d %s found\n", entriesFound, ((entriesFound > 1 || entriesFound == 0) ? "entries" : "entry"));
      System.out.println("\nPress enter to continue...");
      read.nextLine();
  }
```