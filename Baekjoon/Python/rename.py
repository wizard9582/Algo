import os
import re

def rename_files_in_directory(directory):

    print(1234)

    for filename in os.listdir(directory):
        match = re.match(r"(q\d+)_BOJ_(.*?)\.(py|java)", filename)
        if match:
            print(filename)
            prefix, name, ext = match.groups()
            new_filename = f"{prefix}_{name}.{ext}"
            old_path = os.path.join(directory, filename)
            new_path = os.path.join(directory, new_filename)
            os.rename(old_path, new_path)
            print(f'Renamed: {filename} -> {new_filename}')

# 현재 스크립트가 실행되는 디렉토리를 기준으로 변경하려면 '.'을 사용
rename_files_in_directory('c:/vscode/Algo/Baekjoon/Java/')