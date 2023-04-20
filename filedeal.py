# 打开文件并读取内容
with open('D:\\桌面\\综合实践\\yuan.txt', 'r', encoding='utf-8') as f:
    content = f.read()

# 将内容按行分割，并去除每行两端的空格
lines = content.strip().split('\n')
lines = [line.strip() for line in lines]

# 使用字典统计每个词语在文件中出现的次数，并使用set记录所有出现过的词语
word_count = {}
words = set()
for line in lines:
    parts = line.split(',')
    for part in parts:
        word = part.strip().replace('"', '')
        if word in word_count:
            word_count[word] += 1
        else:
            word_count[word] = 1
            words.add(word)

# 输出结果
print("不重复的词语数量为：", len(words))
print("每个词语在文件中出现的次数为：", word_count)

