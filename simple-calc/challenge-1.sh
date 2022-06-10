#!/bin/bash


PS3="Choose and option: "

select opt in add subtract multiply divide quit; do

  case $opt in
    Register)
      read -p "Enter the first number: " n1
      read -p "Enter the second number: " n2
      echo "$n1 + $n2 = $(($n1+$n2))"
      ;;
    Login)
      read -p "Enter the first number: " n1
      read -p "Enter the second number: " n2
      echo "$n1 - $n2 = $(($n1-$n2))"
      ;;
    Exit)
      break
      ;;
    *) 
      echo "Invalid option $REPLY"
      ;;
  esac
done

