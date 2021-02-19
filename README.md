# parking-lot
In this project, we will create a parking lot management program that keeps track of vacant spots and parked cars.

https://github.com/chudu13/parking-lot.wiki.git
The parking lot should allow the user to park the car.
You can enter the following commands on the command line:
1)create (to specify the number of spots on the parking lot) - For example -> create 10
2)park (to park the car) - After the user has entered this command, the registration number and the color of the car should be specified. For example -> park KA-01-HH-1234 Blue.The registration number should not contain spaces. The color can be written in either uppercase and lowercase letters.
3)leave (to pick up the car) - After the user has entered this command, the number of the parking spot should be specified. For example -> leave 1
4)reg_by_color (to get numbers of cars of a particular color) - The color may be written in uppercase or lowercase letters. For example -> reg_by_color BLACK
5)spot_by_color (to get parking space numbers of all the cars of a particular color) - Is similar to the previous one
6)spot_by_reg (to get the number of the spot where a car is located) - For example -> spot_by_reg KA-01-HH-3672
7)status (to get all occupied spots in ascending order) - For each spot, it should print the spot number, the car’s plate registration number, and the color of the car, all separated by spaces.
8)exit (to end the program)

Example
The symbol > represents the user input.

> park KA-01-HH-9999 White
Sorry, a parking lot has not been created.
> spot_by_color yellow
Sorry, a parking lot has not been created.
> create 4
Created a parking lot with 4 spots.
> park KA-01-HH-9999 White
White car parked in spot 1.
> park KA-01-HH-3672 White
White car parked in spot 2.
> park Rs-P-N-21 Red
Red car parked in spot 3.
> park Rs-P-N-22 Red
Red car parked in spot 4.
> leave 2
Spot 2 is free.
> status
1 KA-01-HH-9999 White
3 Rs-P-N-21 Red
4 Rs-P-N-22 Red
> reg_by_color GREEN
No cars with color GREEN were found.
> reg_by_color WHITE
KA-01-HH-9999
> spot_by_color GREEN
No cars with color GREEN were found.
> spot_by_color red
3, 4
> spot_by_reg ABC
No cars with registration number ABC were found.
> spot_by_reg KA-01-HH-9999
1
> spot_by_reg Rs-P-N-21
3
> exit
