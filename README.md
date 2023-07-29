## Problem Description
* **Overview:** Array is the most basic structure of computer science. Most operations as well as other 
data structures are built and performed on an array. In this project, you will make an application in 
order to explain three sorting algorithms on an array: `Bubble Sort`, `Quick Sort`, and `Insertion Sort`.

* **Basic knowledge:** Bubble Sort, Quick Sort, and Insertion Sort.

* **Specifications:**
    - GUI: You can freely design your own GUI. However, since the basic aim of the project is to develop an application based on OOP, focus on the interface is not required
    - You can refer to these sources to have some ideas: 
        - https://www.youtube.com/watch?v=nmhjrI-aW5o
        - https://www.youtube.com/watch?v=PgBzjlCcFvc
        - https://www.youtube.com/watch?v=OGzPmgsI-pQ
* **Design:**
    - On the main menu: title of the application, 3 types of Sort Algorithms for the user to choose, help, menu, and quit
        - User must select a sort type in order to start the demonstration
        - The help menu shows the basic usage and aim of the program
        - Quit exits the program. Remember to ask for confirmation
    - In the demonstration
        - A button for creating the array: The user can choose to randomly create an array or input an array for the program
        - A button for starting the algorithm with the created array. Remember to show clearly each step of the sorting
        - A back button for the user to return to the main menu at any time
* **Note:** You MUST use the pure array for this project. If you use any Java implementations, you must 
design your own wrapper to show your OOP design in the project
* **Hints:** In order to design this program with the OOP method, treat each sort type as a class – not an array. 
In this way, you will find there are some similarities between the sortings (input, functions, attributes, etc.)

## Demo
**Menu Screen**
- [x] Title of the Application
- [x] 3 types of Sorting Algorithms to choose
- [x] Help Button
- [x] Quit Button (This is the Close button on the top-right)
![Menu](/design/gui/Menu.png)
**Demonstration Screen**
- [x] A Button to Create a new Array
- [x] User can Input from the keyboard
- [x] A Button to Start Sorting
- [x] A Back Button to Return to the main menu
![Demonstration](/design/gui/Demonstration.png)
## Contribution
* Nguyen Viet Trung- 20214934:
    - DataController class
    - QuickSort class
    -	Write report
    -	Powerpoint presentation
    -	Combine code
* Nguyen Trung Truc- 20214936
    -	InsertionSort class
    -	BubbleSort class
    -	Make demostration video
    -	Combine code
* Pham Quang Trung- 20214935:
    -	MenuScreenController 
    -	DemonstrationController
    -	Combine code
* Phan Dinh Truong- 20214937
    -	MenuScreen.fxml
    -	Demonstration.fxml
    -	Handle Help Button
    -	Handle Quit Button
## References
* This project based on: https://github.com/chriszq/VisualSortingAlgorithms
* Video Demo: https://youtu.be/_M5b8HzrfwE
