def program_process():
    first_name, last_name, username, tmp = datastorage()
    choice = choices()
    choice_response(choice, last_name, first_name, username, tmp)


def datastorage():
    first_name = {}
    last_name = {}
    username = {}
    lines = (line.rstrip('\n') for line in open("UD.txt"))
    tmp = [i for i in lines]
    for i in range(len(tmp[:-1])):
        first_name[tmp[i + 1].split(",")[0]] = tmp[i + 1]
        last_name[tmp[i + 1].split(",")[1]] = tmp[i + 1]
        username[tmp[i + 1].split(",")[2]] = tmp[i + 1]
    return first_name, last_name, username, tmp[1:]


def choices():
    choice = input("What would you like to do today? A: Search by last name, B: Search by first name, C: Search by username, D: Display all users alphabetically by First name, E: Display all users alphabetically by Last name, F: Insert a user. ")
    return choice


def search_by_last_name(last_name):
    user_prompt = input("Enter user's last name: ")
    if user_prompt in last_name:
        print(last_name[user_prompt])
    else:
        print("Not found")
        program_process()


def search_by_first_name(first_name):
    user_prompt = input("Enter user's first name: ")
    if user_prompt in first_name:
        print(first_name[user_prompt])
    else:
        print("Not found")
        program_process()


def search_by_username(username):
    user_prompt = input("Enter user's username: ")
    if user_prompt in username:
        print(username[user_prompt])
    else:
        print("Not found")
        program_process()


def output(tmp, choice):
    if choice == 'D':
        alpha_first_name_tmp = sorted(tmp)
        print(alpha_first_name_tmp)
    elif choice == 'E':
        alpha_last_name_tmp = sorted(tmp, key=lambda x: x.split(",")[-3])
        print(alpha_last_name_tmp)


def insert_user():
    user_info = input("Enter user info in the following format: First name, last name, username, password. ")
    split_user_info = user_info.split(", ")
    fn_new_user, ln_new_user, un_new_user, pw_new_user = split_user_info[0], split_user_info[1], split_user_info[2], split_user_info[3]
    user_file = open("UD.txt", 'a')
    print(fn_new_user + ',' + ln_new_user + ',' + un_new_user + ',' + pw_new_user, file=user_file)


def choice_response(choice, last_name, first_name, username, tmp):
    if choice == 'A':
        search_by_last_name(last_name)
    elif choice == 'B':
        search_by_first_name(first_name)
    elif choice == 'C':
        search_by_username(username)
    elif choice == 'D' or choice == 'E':
        output(tmp, choice)
    elif choice == 'F':
        insert_user()


program_process()
