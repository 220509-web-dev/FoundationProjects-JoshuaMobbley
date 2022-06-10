#!/bin/bash

echo "Type your First Name: "
read firstname
echo "Type your Last Name: "
read lastname
echo "Type your email address: "
read email
echo "Type your username: "
read username
echo "Type your password: "
read password

echo "$firstname, $lastname, $email, $username, $password" >>get-store.csv
