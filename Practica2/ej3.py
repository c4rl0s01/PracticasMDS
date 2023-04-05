import re

new = input()

pattern = r"(.*\b)(\d{4}\-[0,1][0-9]\-[0-3][0-9])(\b.*)"
results = re.search(pattern, new)
results_replaced = re.sub('-', '.', results.group(2)).split('.')
print(results.group(1)+results_replaced[2]+'.'+results_replaced[1]+'.'+results_replaced[0]+results.group(3))
