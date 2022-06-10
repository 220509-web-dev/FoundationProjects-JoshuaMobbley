#!/bin/bash

set a b operation;

echo -e "Select operation type: + - * /";
read operation;
echo "a=";
read a;
echo "b="
read b;

echo "Result:" $(($a$operation$b));
