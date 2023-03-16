import re

new = input()

pattern = r"\b\d{4}\b"

results = re.findall(pattern, new)
for match in results:
    print(match)
