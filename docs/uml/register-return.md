# UC-07: Register a return

| Field | Description |
|---|---|
| **Use Case ID & Name** | UC-07 – Register a return |
| **Primary Actor** | Librarian |
| **Secondary Actor** | Mail server (`<<system>>`) |
| **Precondition** | The librarian is authenticated. |
| **Trigger** | A member brings back one or more borrowed copies to return. |
| **Main Scenario** | 1. The librarian starts the return registration process.<br>2. The librarian scans the barcode of the returned copy.<br>3. The system verifies that the copy is currently on loan and updates the loan and copy status.<br>4. Steps 2–3 are repeated for any additional returned copies.<br>5. If applicable, the system notifies the Mail server (e.g., for overdue notice or reservation alert).<br>6. The system prints the receipt (`Print the receipt`). |
| **Extensions / Alternative Flows** | **1a. Barcode cannot be read (`le code-barres ne se lit pas`):**<br>1a.1. The system displays a barcode read error.<br>1a.2. The librarian enters the copy identifier manually or retries scanning; resume main scenario at step 3.<br><br>**2a. Copy is not on loan (`l'exemplaire n'est pas en prêt`):**<br>2a.1. The system informs the librarian that the copy is not currently on loan.<br>2a.2. The librarian checks the copy status and sets it aside if needed; return to step 2 or end return for this item. |
| **Postcondition** | Returned copies are recorded as returned, loan records are updated, and the receipt is printed. |
