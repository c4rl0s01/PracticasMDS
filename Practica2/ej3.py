import re

new = input()

pattern = r"\b(\d{4})-(\d{2})-(\d{2})\b"
sub_pattern = r'\3.\2.\1'
results_replaced = re.sub(pattern, sub_pattern, new)
print(results_replaced)
