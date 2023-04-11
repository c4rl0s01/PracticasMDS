import re

#Mi tractor tiene la matricula E-1234 ABC, mi coche 0011AAB.

new = input()
pattern = r'(\bE[-|\s\S]?[0-9]{4}[|\s|\-]?[A-Z]{3})|([0-9]{4}[-|\s\S][A-Z]{3}\b)'

x = re.findall(pattern, new)


for match in x:
    print(*match)