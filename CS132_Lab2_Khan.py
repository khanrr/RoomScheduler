def start_login():
    response = greeting()
    while response != 'L' and response != 'C':
        response = greeting()
        if response == 'L' and response == 'C':
            break
    if response == 'L':
        login()
    elif response == 'C':
        un, pw = create()
        pwcheck(un, pw)
        print("User created.")


def greeting():
    response = input("Login or create a new user? Select L to login, select C to create new user. ")
    return response


def login():
    logfile = open("UD.txt", 'r')
    txtfile = logfile.read()
    un = input("Please enter your user name and hit enter: ")
    if un in txtfile:
        pw = input("Enter password: ")
        if pw in txtfile:
            print("You are logged in")
        else:
            print("Wrong password")
            start_login()
    else:
        print("User not found")
        start_login()


def create():
    create_account = input("Please enter your first name, last name, and student ID, separated by a space: ")
    splitun = create_account.split(" ")
    fn, ln, sid = splitun[0], splitun[1], splitun[2]
    un = fn[:1] + ln[:2] + sid[:3]
    pw = input("Please enter password: ")
    return un, pw


def pwcheck(un, pw):
    repw = input("Please reenter password: ")
    if pw == repw:
        logfile = open("UD.txt", 'a')
        print(un.lower() + ',' + pw, file=logfile)
    else:
        print("Password did not match")
        pwcheck(un, pw)


start_login()
