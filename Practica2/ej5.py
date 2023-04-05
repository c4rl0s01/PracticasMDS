import re

new = input()

pattern = r"(Calle|C\/)\s([A-Z][a-z]+),?\s+(Nº|nº7|N\b|n\b|\b|Nº\b|nº\b|n|N)(\d+),\s+([0-9]{5})"
results = re.findall(pattern, new)
for match in results:
    print(match[4], match[1], match[3], sep='-')

