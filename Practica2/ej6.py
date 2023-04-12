import re

new = input()

pattern = r"([A-Za-z]{1,}).{1,}\[([a-zA-Z0-9]{1,})\]\s+(.{1,}\S)\s+\:\s+(.{1,})"

results = re.search(pattern, new)

#2022-02-07 01:14:28.313  INFO 1174086 --- [main] drfp.Main            : Starting Main v0.1-SNAPSHOT using Java 17.0.1 on raul2-ubuntu with PID 1174086 started by rmartin
#2023-02-07 01:14:29.806 INFO 1174086 --- [main] TomcatWebServer : Tomcat initialized with port(s): 8080 (http)


if results:
    level_log = results.group(1)
    thread_log = results.group(2)
    class_log = results.group(3)
    message_log = results.group(4)

    if class_log.__contains__("."):
        class_split = class_log.split(".")
        l = len(class_split) - 1
        class_log = class_split[l]


    print(f'"{level_log}","{thread_log}","{class_log}","{message_log}"')
