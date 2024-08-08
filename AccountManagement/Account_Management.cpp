#include <iostream>
#include <string>
#include <iomanip>
using namespace std;
//Declare structure for cutsimer details
struct CustomerAccount
{
    string c_name;
    string c_address;
    string c_city;
    string c_state;
    int ZIP_code;
    double telephoneNumber;
    double accountBalance;
    string dateOfLastPayment;
};

//function prototypes
CustomerAccount getDetails(CustomerAccount &);
int getCustomer(CustomerAccount[], int, string);
void displayDetails(CustomerAccount[], int);

//main method
int main()
{
    //declare the size
    const int SIZE = 20;

    //array size
    CustomerAccount customers[SIZE];
    CustomerAccount customer;
    //declare local variables
    int customerChoice;
    int count = 0;
    int cust_count = 0;
    string fullName;
    int change;
    //use do-while loop to repeat the code until 
    //user wants to exit from the program
    do
    {
        //print the menu
        cout << endl;
        cout << "---------------MENU---------------" << endl;
        cout << "1.Enter new account information: " << endl;
        cout << "2.Change account information: " << endl;
        cout << "3.Display all account information: " << endl;
        cout << "4.Exit the program" << endl;
        cout << "Enter your choice (1/2/3/4): ";
        cin >> customerChoice;
        //switch case for each menu option
        switch (customerChoice)
        {
        case 1:
            customers[count] = getDetails(customer);
            cout << "You have entered information for customer number "
                << count << endl;
            count++;
            cust_count = count;
            break;
        case 2:
            //prompt for customer number
            cout << "Enter customer number: ";
            cin >> count;
            //print the details
            cout << "Customer name: " 
                << customers[count].c_name << endl;
            cout << "Customer address: "
                << customers[count].c_address << endl;
            cout << "City: " << customers[count].c_city 
                            << endl;
            cout << "State: " << customers[count].c_state 
                            << endl;
            cout << "ZIP code: " << setprecision(10) 
                << customers[count].ZIP_code << endl;
            cout << "Telephone: " << setprecision(15)
                << customers[count].telephoneNumber << endl;
            cout << "Account balance: $" << setprecision(15) 
                << customers[count].accountBalance << endl;
            cout << "Date of last payment: " 
                << customers[count].dateOfLastPayment << endl;
            //prompt and read the full name of the customer
            cout << endl << "Enter full name of customer to be modified: ";
            cin >> fullName;
            change = getCustomer(customers, count, fullName);
            //if the name is not valid
            //print the message and break from the case
            if (change == -1)
            {
                cout << endl << "Wrong customer name to change" << endl;
            }
            //otherwise reprompt for changing details
            else
            {
                customers[change] = getDetails(customer);
            }
            break;
        //display details
        case 3:
            displayDetails(customers, cust_count);
            break;

        //exit from the switch case
        case 4:
            exit(0);
        default:
            cout << "Only Enter 1, 2, 3, or 4." << endl;
        }
    } while (customerChoice != 4 && count < SIZE);
    return 0;
}

//Implement method to read the details of the customer
CustomerAccount getDetails(CustomerAccount &obj)
{
    cout << endl;
    //prompt and read the customer name
    cout << "Enter the name of customer: ";
    cin >> obj.c_name;
    //prompt and read the customer address
    cout << "Enter the address of customer: \n";
    cin >> obj.c_address;
    //prompt and read the customer city
    cout << "Enter the city of customer: ";
    cin >> obj.c_city;
    //prompt and read the customer state
    cout << "Enter the state of customer: ";
    cin >> obj.c_state;
    //prompt and read the customer ZIP code
    cout << "Enter the ZIP code: ";
    cin >> obj.ZIP_code;
    //prompt and read the customer telephone number
    cout << "Enter the telephone number: ";
    cin >> obj.telephoneNumber;

    //prompt and read the customer account balance
    cout << "Enter the account balance: $";
    cin >> obj.accountBalance;
    //check for the invalid daetails
    while (obj.accountBalance < 0)
    {
        cout << "Enter the positive value: $";
        cin >> obj.accountBalance;
    }
    //prompt and read the date of last payment
    cout << "Enter the date of last payment in the form of - dd/mm/yyyy: ";
    cin >> obj.dateOfLastPayment;
    //return the object of the array
    return obj;
}
//implement method to return the customer number
int getCustomer(CustomerAccount cust[], int size, string name)
{
    int customer_number = -1;
    for (int i = 0; i <=size; i++)
    {
        if (cust[i].c_name == name)
        {
            customer_number = i;
            break;
        }
    }
    return customer_number;
}

//implement method to dsiplay the list of custmers
void displayDetails(CustomerAccount customers[], int size)
{
    //if size is 0
    if (size == 0)
    {
        //print message
        cout << endl << "No customers in the array to display" << endl;
    }
    //otherwise print the details of each customer
    else
    {
        for (int i = 0; i <size; i++)
        {
            cout << endl;
            cout << "Customer name: " 
                << customers[i].c_name << endl;
            cout << "Customer address: " 
                << customers[i].c_address << endl;
            cout << "City: " << customers[i].c_city << endl;
            cout << "State: " << customers[i].c_state << endl;
            cout << "ZIP code: " << setprecision(10) 
                << customers[i].ZIP_code << endl;
            cout << "Telephone: " << setprecision(15) 
                << customers[i].telephoneNumber << endl;
            cout << "Account balance: $" << setprecision(15) 
                << customers[i].accountBalance << endl;
            cout << "Date of last payment: " 
                << customers[i].dateOfLastPayment << endl;
        }
    }
}