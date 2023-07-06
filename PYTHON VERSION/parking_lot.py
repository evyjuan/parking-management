import os
import random
import time

# Lot information and data structure
spaces = []
avail_spaces = 0
total_spaces = 0
rows = 0

# Display function variables
space_count = 0
border = ""

# Flags
linux = 0

KEY = "123".encode()
have_key = False


# Vehicle class, has a type and a plate number, upon creation, stores current epoch time for later fare calculation
class Vehicle:
    def __init__(self, v_type, plate):
        self.type = v_type
        self.plate = plate
        self.entry_time = time.time()

    # Return type value (int)
    def get_type(self):
        return self.type

    # Return type value (string)
    def get_type_string(self):
        return "Car" if self.type == 1 else "Truck" if self.type == 2 else "Motorcycle"

    def get_plate(self):
        return self.plate

    def get_entry_time(self):
        return self.entry_time

    # Set epoch time manually - used for demo mode
    def set_entry_time(self, new_time):
        self.entry_time = new_time

    def get_vehicle(self):
        return self.type, self.plate, self.entry_time


# Space class, stores a vehicle object and current occupied status
class Space:
    def __init__(self):
        self.vehicle = None
        self.occupied = False

    def add_vehicle(self, vehicle):
        self.vehicle = vehicle
        self.occupied = True

    # Remove a vehicle from a space and return object for final fare calculation
    def remove_vehicle(self):
        v_exit = self.vehicle
        self.vehicle = None
        self.occupied = False
        return v_exit

    def vehicle_info(self):
        return self.vehicle

    def is_available(self):
        return self.occupied


def print_row(row):
    output = ""
    output += "|"
    for s in range(space_count * row, space_count * (row + 1)):
        if not spaces[s].is_available():
            output += "[ ]"
        else:
            output += "["
            output += "c" if spaces[s].vehicle_info().get_type() == 1 \
                else "t" if spaces[s].vehicle_info().get_type() == 2 \
                else "m"
            output += "]"
        if s < space_count * (row + 1) - 1:
            output += " "
    output += "|"

    return output


# Display all spaces with availability
def display_lot():
    global spaces, avail_spaces, total_spaces, rows

    # Generate the interface
    output = "SPOTS AVAILABLE: " + str(avail_spaces) + "\n"

    output += border

    for row in range(rows):
        output += print_row(row) + "\n"

    output += border

    # Only uncomment when running on a Linux machine
    if linux == 1:
        os.system("clear")
    print(output)


# Display all spaces with row selection numbers for the user to choose from
def display_row_selection():
    global spaces, avail_spaces, total_spaces, rows

    # Generate the interface
    output = "SPOTS AVAILABLE: " + str(avail_spaces) + "\n"

    output += border
    for row in range(rows):
        output += print_row(row)
        output += " <" + str(row) + ">\n"
    output += border

    # Only uncomment when running on a Linux machine
    if linux == 1:
        os.system("clear")
    os.system("clear")
    print(output)


# Display a specified row with space selection numbers for the user to choose from
def display_space_selection(row):
    global spaces, avail_spaces, total_spaces, rows

    output = "VIEWING ROW: " + row + "\n"

    output += border
    output += print_row(int(row)) + "\n"

    output += " "
    for count in range(space_count):
        if count < 10:
            output += "<" + str(count) + "> "
        else:
            output += "<" + str(count) + ">"

    output += "\n"
    output += border

    if linux == 1:
        os.system("clear")
    print(output)

    return space_count


# Save vehicle information to a text file
def save_vehicle_info(vehicle, x, y):
    file_path = "vehicle_info.txt"

    with open(file_path, "a") as file:
        v_type = encrypt(vehicle.get_type_string())
        plate = encrypt(vehicle.get_plate())
        entry_time = encrypt(str(vehicle.get_entry_time()))
        rate = encrypt(str(calculate_fare(vehicle)))
        X = encrypt(x)
        Y = encrypt(y)

        line = f"{v_type}, {plate}, {entry_time}, {rate}, {X}, {Y}\n"
        file.write(line)


def ret_key():
    global KEY
    global have_key
    if os.path.exists("en_key.txt"):
        try:
            with open("en_key.txt", 'r') as r_key:
                KEY = r_key.readline().rstrip()
                KEY = KEY.encode()
                have_key = True
        except IOError as e:
            print("ERROR:", e)
    else:   # generate new temporary key
        KEY = str(random.randint(0, 9**9))
        KEY = KEY.encode()
        try:
            with open("en_key.txt", 'wb') as r_key:
                r_key.write(KEY)
                have_key = True
        except IOError as e:
            print("ERROR:", e)


def retrieve_info(key):
    global have_key
    type_v = 0
    if os.path.exists('vehicle_info.txt'):
        with open('vehicle_info.txt', 'r') as file:
            lines = file.readlines()

        if key == 1:
            for line in lines:
                tokens = line.strip().split(",")

                if have_key:
                    v_type = decrypt(tokens[0])
                    plate = decrypt(tokens[1])
                    entry_time = float(decrypt(tokens[2]))
                    row = decrypt(tokens[4])
                    space = decrypt(tokens[5])
                else:
                    v_type = tokens[0]
                    plate = tokens[1]
                    entry_time = float(tokens[2])
                    row = tokens[4]
                    space = tokens[5]

                if v_type == "Car":
                    type_v = 1
                elif v_type == "Truck":
                    type_v = 2
                elif v_type == "Motorcycle":
                    type_v = 3
                else:
                    print("Invalid Vehicle Type.")
                enter_vehicle(type_v, plate, row, space, 2, 1, entry_time)
        elif key == 2:
            print("Vehicles Log Information:")
            for line in lines:
                print(line.strip())
        else:
            print("Wrong Parameters")


# Used to park a vehicle within the lot
def enter_vehicle(v_type, plate, row, space, key, r_key, r_time):
    global spaces, avail_spaces, total_spaces, rows

    # Do not allow a user to park a vehicle with a full lot
    if avail_spaces == 0:
        display_lot()
        print("Error: No Available Spaces")
        time.sleep(2)
        return

    # Check if a specified space is already occupied
    if spaces[(int(row) * space_count) + int(space)].is_available():
        display_space_selection(row)
        print("Error: Vehicle Already In Space")
        time.sleep(2)
        return -1

    # Check if the specified plate number is in the lot
    for uniq in spaces:
        if uniq.is_available():
            if uniq.vehicle_info().get_plate() == plate:
                display_lot()
                print("Error: Vehicle Already In Lot")
                time.sleep(2)
                return

    # Add a valid vehicle to the specified space and show the time of entry
    new_vehicle = Vehicle(v_type, plate)
    spaces[(int(row) * space_count) + int(space)].add_vehicle(new_vehicle)
    avail_spaces -= 1
    display_lot()
    if r_key == 1:
        new_vehicle.set_entry_time(r_time)

    print("Time Entered: " + str(time.strftime('%I:%M %p', time.localtime(new_vehicle.get_entry_time()))))

    # time.sleep(2)

    # Save vehicle information to the text file
    if key == 1:
        save_vehicle_info(new_vehicle, row, space)

    return new_vehicle


# Used to calculate the fare of a vehicle
def calculate_fare(vehicle):
    # Calculate the number of seconds which have passed since a vehicle was entered into the system
    # If less than one hour has passed, then a minimum fare of one hour is priced
    total_time = time.time() - vehicle.get_entry_time()
    if total_time < 3600:
        hours = 1
    else:
        hours = int(total_time / 3600) + 1

    # Calculate fare based on the vehicle type
    if vehicle.get_type() == 1:
        rate = hours * 100
    elif vehicle.get_type() == 2:
        rate = hours * 200
    else:
        rate = hours * 50

    return rate


# Used to remove a vehicle from the lot
def exit_lot(row, space):
    global avail_spaces

    # Check if a specified space is occupied
    if not spaces[(int(row) * space_count) + int(space)].is_available():
        display_space_selection(row)
        print("Error: No Vehicle In Space")
        time.sleep(2)
        return

    # If the specified plate number is found within the lot, the vehicle is removed
    removed = spaces[(int(row) * space_count) + int(space)].remove_vehicle()
    avail_spaces += 1

    # Calculate fare if a vehicle is removed
    display_lot()
    print(calculate_fare(removed))
    time.sleep(2)


# Used to view a currently parked vehicle's information
def view_vehicle(row, space):

    # Check if a specified space is occupied
    if not spaces[(int(row) * space_count) + int(space)].is_available():
        display_space_selection(row)
        print("Error: No Vehicle In Space")
        time.sleep(2)

    # Collect vehicle information and display it to the user
    else:
        vehicle = spaces[(int(row) * space_count) + int(space)].vehicle_info()
        display_space_selection(row)
        input("Vehicle Type: " + vehicle.get_type_string() + "\n"
                                                             "Plate Number: " + vehicle.get_plate() + "\n"
                                                                                                      "Entry Time: " + str(
            time.strftime('%m-%d-%Y %I:%M %p',
                          time.localtime(vehicle.get_entry_time()))) + "\n"
                                                                       "\nPress Enter to return to the menu")


# Handles user commands as determined in main
def command_handler(command):
    # Command to park a car
    if command == "P":
        while True:
            display_lot()
            new_type = input("Enter Vehicle Type:\n"
                             "1. Car\n"
                             "2. Truck\n"
                             "3. Motorcycle\n"
                             ">")
            if new_type == "1" or new_type == "2" or new_type == "3":
                break

        # Program will accept any valid string as a plate number
        display_lot()
        new_plate = input("Enter New Vehicle Plate Number:\n"
                          ">")

        # Allow the user to select the space they want to park in
        # While loop is used in case the user selects a spot that already has a vehicle
        # or if the user inputs a plate number that has already been added
        ret_val = -1
        while ret_val == -1:
            while True:
                display_row_selection()
                row = input("Select Row to Park In:\n"
                            ">")
                if row.isnumeric():
                    if int(row) < rows:
                        break
            while True:
                display_space_selection(row)
                space = input("Select Space to Park In:\n"
                              ">")
                if space.isnumeric():
                    if int(space) < space_count:
                        break
            ret_val = enter_vehicle(int(new_type), new_plate, row, space, 1, 2, 0)

    # Command for exiting the lot
    elif command == "E":

        # User can specify a row and space within the lot, if a selected space is occupied,
        # vehicle information is returned
        while True:
            display_row_selection()
            row = input("Select Row of Vehicle:\n"
                        ">")
            if row.isnumeric():
                if int(row) < rows:
                    break

        while True:
            display_space_selection(row)
            space = input("Select Space of Vehicle:\n"
                          ">")
            if space.isnumeric():
                if int(space) < space_count:
                    break
        # Program will check for a vehicle plate within the system and remove it if found, returns error if no plate found
        exit_lot(row, space)

    # Command for viewing a vehicle's information
    elif command == "V":

        # User can specify a row and space within the lot, if a selected space is occupied,
        # vehicle information is returned
        while True:
            display_row_selection()
            row = input("Select Row to View:\n"
                        ">")
            if row.isnumeric():
                if int(row) < rows:
                    break

        while True:
            display_space_selection(row)
            space = input("Select Space to View:\n"
                          ">")
            if space.isnumeric():
                if int(space) < space_count:
                    break
        view_vehicle(row, space)

    # Display current parking lot rates
    elif command == "R":
        display_lot()
        input("Current Parking Rates:\n"
              "Cars - PHP 100/hour\n"
              "Trucks - PHP 200/hour\n"
              "Motorcycles - PHP 50/hour\n"
              "\nPress Enter to return to the menu")

    elif command == "L":
        retrieve_info(2)

    elif command == "CH":
        global KEY
        temp_file()
        while True:
            new_key = input("Enter new key: ")
            new_key = new_key.encode()
            if new_key != KEY:
                try:
                    with open("en_key.txt", 'wb') as r_key:
                        r_key.write(new_key)
                except IOError as e:
                    print("ERROR:", e)
                break
        KEY = new_key

        with open('temp_vehicle_info.txt', 'r') as file:
            lines = file.readlines()
        with open("vehicle_info.txt", "w") as s_file:
            for line in lines:
                tokens = line.strip().split(",")

                v_type = encrypt(tokens[0])
                plate = encrypt(tokens[1])
                entry_time = encrypt(str(tokens[2]))
                rate = encrypt(str(tokens[3]))
                row = encrypt(tokens[4])
                space = encrypt(tokens[5])

                s_line = f"{v_type}, {plate}, {entry_time}, {rate}, {row}, {space}\n"
                s_file.write(s_line)
        os.remove('temp_vehicle_info.txt')

    # Return if the quit command is given
    elif command == "Q":
        return

    # Display an error if an invalid command is given
    else:
        display_lot()
        print("Error: Invalid Command")
        time.sleep(1)


def temp_file():
    with open('vehicle_info.txt', 'r') as file:
        lines = file.readlines()

    with open("temp_vehicle_info.txt", "a") as s_file:
        for line in lines:
            tokens = line.strip().split(",")

            if have_key:
                v_type = decrypt(tokens[0])
                plate = decrypt(tokens[1])
                entry_time = float(decrypt(tokens[2]))
                rate = decrypt(tokens[3])
                row = decrypt(tokens[4])
                space = decrypt(tokens[5])

            else:
                v_type = tokens[0]
                plate = tokens[1]
                entry_time = float(tokens[2])
                rate = tokens[3]
                row = tokens[4]
                space = tokens[5]

            s_line = f"{v_type}, {plate}, {entry_time}, {rate}, {row}, {space}\n"
            s_file.write(s_line)


# Read config file to determine lot size and enable features
def read_config():
    global spaces, total_spaces, avail_spaces, rows, linux, space_count, border

    config = open('config.txt', 'r')
    while True:
        line = config.readline()

        if line.find("total_spaces") != -1:
            total_spaces = int(line[13:16])
            avail_spaces = total_spaces

        elif line.find("rows") != -1:
            rows = int(line[5:7])

        # Enables static interface on Linux machines
        elif line.find("linux") != -1:
            linux = int(line[6:7])

        # If demo mode is enabled, populate the lot with demo cars; otherwise, populate the lot based on the config
        elif line.find("demo_mode") != -1:
            if int(line[10:11]) == 1:
                demo_mode()
                break
            else:
                for i in range(total_spaces):
                    spaces.append(Space())

                # Calculate the number of spaces within a row
                space_count = int(total_spaces / rows)

                # Generate the interface border
                border = "|"
                for i in range(space_count - 1):
                    for j in range(4):
                        border += "-"
                border += "---|\n"
                break

    config.close()


def encrypt(plain_text):
    global KEY
    plain_text = plain_text.encode()
    encrypted = bytearray()
    for i in range(len(plain_text)):
        encrypted.append(plain_text[i] ^ KEY[i % len(KEY)])
    return encrypted.hex()


def decrypt(encrypted_text):
    global KEY
    decrypted = bytearray.fromhex(encrypted_text)
    plain_text = bytearray()
    for i in range(len(decrypted)):
        plain_text.append(decrypted[i] ^ KEY[i % len(KEY)])
    return plain_text.decode()


def demo_mode():
    global spaces, total_spaces, avail_spaces, rows, space_count, border

    for i in range(total_spaces):
        spaces.append(Space())

    total_spaces = 20
    avail_spaces = 20
    rows = 4

    # Calculate the number of spaces within a row
    space_count = int(total_spaces / rows)

    # Generate the interface border
    border = "|"
    for i in range(space_count - 1):
        for j in range(4):
            border += "-"
    border += "---|\n"

    v1 = enter_vehicle(1, "aaa-bbbb", 0, 3, 2, 0, 0)
    v2 = enter_vehicle(3, "ccc-dddd", 1, 2, 2, 0, 0)
    v3 = enter_vehicle(2, "eee-ffff", 2, 0, 2, 0, 0)
    v4 = enter_vehicle(1, "ggg-hhhh", 3, 1, 2, 0, 0)
    v5 = enter_vehicle(2, "iii-jjjj", 2, 4, 2, 0, 0)

    # Custom epoch times
    v1.set_entry_time(1620561600)
    v2.set_entry_time(1620570600)
    v3.set_entry_time(1620577800)
    v4.set_entry_time(1620576000)
    v5.set_entry_time(1620586800)


def main():

    # Read config file
    read_config()

    ret_key()

    # Read file
    retrieve_info(1)

    # Begin accepting user commands
    command = ""
    while command != "Q":
        display_lot()
        print("Please Select An Option:\n"
              "P - Park a Vehicle\n"
              "E - Exit the Lot\n"
              "V - View a Parked Vehicle\n"
              "R - Display Vehicle Rates\n"
              "L - Display Vehicle Logs\n"
              "CH - Change Key\n"
              "Q - Quit Application\n")

        command = input(">")
        command_handler(command)


if __name__ == '__main__':
    main()
