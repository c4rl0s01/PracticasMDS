import re

new = input()

pattern = r"\b(([a-z]{1,})\.([a-z]{2,})@urjc\.es)|\b(([a-z]{1})\.([a-z]{2,})\.([0-9]{4})@alumnos\.urjc\.es)"

results = re.findall(pattern, new)


for match in results:
    if match[0] != "":
        print("profesor "+match[1]+" apellido "+match[2])
    else:
        print("alumno "+match[5]+" matriculado en "+match[6])

