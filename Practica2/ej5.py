import re

new = input()

pattern = r"\b(C\/|Calle)\s([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+),?\s+(Nº|nº|N\s|n\s|Nº\s|nº\s|n|N)?(\d+),\s+([0-9]{5})\b"
results = re.findall(pattern, new)
for match in results:
    print(match[4], match[1], match[3], sep='-')

