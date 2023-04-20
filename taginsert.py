import re
# # 输出结果
# print("词语列表为：", words)
# print("数字列表为：", numbers)
if __name__ == '__main__':
    import pymysql

    # MySQL数据库连接信息
    MYSQL_HOST = '175.178.213.250'
    MYSQL_USER = 'manager1'
    MYSQL_PASSWORD = 'xbpcL8tTCCFPSdfR'
    MYSQL_DB = 'ChuCi'
    # JSON文件夹路径
    JSON_FOLDER = 'D:/桌面/综合实践/诗词数据库/poetry-master/poetry'
    flag=0
    # 打开JSON文件夹并读取数据
    if __name__ == '__main__':
        # 打开文件并读取内容
        with open('D:\\桌面\\综合实践\\tags.txt', 'r', encoding='utf-8') as f:
            content = f.read()

        # 使用正则表达式解析文件内容
        pattern = r"'(.*?)':\s*(\d+),?"
        matches = re.findall(pattern, content)

        # 将词语和数字分别存储到两个列表中
        words = [match[0] for match in matches]
        numbers = [int(match[1]) for match in matches]
        # 连接MySQL数据库
        connection = pymysql.connect(host=MYSQL_HOST,
                                     user=MYSQL_USER,
                                     password=MYSQL_PASSWORD,
                                     db=MYSQL_DB,
                                     charset='utf8mb4',
                                     cursorclass=pymysql.cursors.DictCursor)
        try:
            for word, number in zip(words, numbers):
                with connection.cursor() as cursor:
                    sql = "insert into tags values (%s, %s)"
                    cursor.execute(sql, (word,number))
                    connection.commit()
        finally:
            connection.close()
