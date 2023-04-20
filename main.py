# coding=utf-8
# 这是一个示例 Python 脚本。

# 按 Shift+F10 执行或将其替换为您的代码。
# 按 双击 Shift 在所有地方搜索类、文件、工具窗口、操作和设置。

# 按间距中的绿色按钮以运行脚本。
if __name__ == '__main__':
    import os
    import json
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
        for filename in os.listdir(JSON_FOLDER):
            if filename.endswith('.json') and filename[7] == '9':
                with open(os.path.join(JSON_FOLDER, filename), 'r', encoding='UTF-8') as f:
                    data = json.load(f)

                # 连接MySQL数据库
                connection = pymysql.connect(host=MYSQL_HOST,
                                             user=MYSQL_USER,
                                             password=MYSQL_PASSWORD,
                                             db=MYSQL_DB,
                                             charset='utf8mb4',
                                             cursorclass=pymysql.cursors.DictCursor)
                try:
                    with connection.cursor() as cursor:
                        # id=json.dumps(data['id'])
                        # nid=int(id[0])
                        # 遍历JSON数据并将其插入到MySQL数据库
                        # tags = ",".join(data['tags'])
                        sql = "REPLACE INTO poetry(id,star,content,name,dynasty,tag,Poet_id) VALUES (%s, %s, %s, %s, %s, %s, %s)"
                        # if (data['star']>15):
                        # print(data['id'])
                        tags = ",".join(data['tags'])
                        flag+=1
                        cursor.execute(sql, (data['id'], data['star'], data['content'], data['name'],
                                               data.get("dynasty"), tags ,data['poet']['id']))
                        if flag==200:
                            print(data['id'])
                            flag=0
                        connection.commit()
                finally:
                    connection.close()


