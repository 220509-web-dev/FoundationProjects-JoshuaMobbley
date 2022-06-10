#!/bin/bash

echo Welcome to Quizzard!
echo "Please select from the following options: "

echo "1) Register"
echo "2) Login"
echo "3) Exit"

read selection

if [ $selection = "1" ] -o [ $selection = "Register"]; then
   echo "Please provide us with some basic information to complete your registration"
   read -p "First Name: " firstname
   read -p "Last Name: " lastname
   read -p "Email address: " email
   read -p "Username: " username
   read -p "Password: " password

echo "$firstname,$lastname,$email,$username,$password" >> data.csv

elif [ $selection = "2" ]; then
   echo "Please provide your username and password to login to your account"
   read -p "Username: " username
   read -p "Password: " password

   exec < data.csv
   read header

   while IFS="," read -r f l e u p; do
     if  [ $u = $username ] && [ $p = $password ]; then
   echo "Record found: $f,$l,$e,$u,$p"
   exit 0
    fi
 done < data.csv

echo "No record found using provided credenntials!"
elif  [ $selection = "3" ]; then
echo "Closing Application."
exit 0
else
echo "Invalid  Selection!"
fi
