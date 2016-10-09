Challenge
==============================

Write a program that plays 100 iterations of Rock, Paper, Scissors 
One player → play randomly
Second player → always play rock
The program have to show at the end how many games each player has one and how many were a draw.

Solution approach
==============================
Shapes: Rock = 0, Paper = 1 and Scissors=2
Core of the algorithm is given by a note:
The moves are in a cycle. In order to determinate the winner the follow mathematical formula is useful:
x = (n + a - b) % n 
where 
n = number of total shapes 
a = first shape (by ordinal code)
b = second shape (by ordinal code)

