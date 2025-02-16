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
# rename_files_in_directory('c:/vscode/Algo/Baekjoon/Java/')


import requests

def get_problem_title(problem_id):
    url = f"https://www.acmicpc.net/problem/{problem_id}"
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
    }
    response = requests.get(url, headers=headers)
    if response.status_code != 200:
        print(f"Failed to fetch problem title for {problem_id}, HTTP Status: {response.status_code}")
        return None
    
    text = response.text
    title_start = text.find('<span id="problem_title">')
    if title_start == -1:
        return None
    
    title_start += len('<span id="problem_title">')
    title_end = text.find('</span>', title_start)
    if title_end == -1:
        return None
    
    return text[title_start:title_end].strip()

def rename_java_files(directory):
    for filename in os.listdir(directory):
        # Skip files that are already in the correct format
        if re.match(r"q\d+_.+\.java", filename):
            continue
        
        match = re.match(r"(q\d+)\.java", filename)
        if match:
            problem_id = match.group(1)[1:]
            problem_title = get_problem_title(problem_id)
            if problem_title:
                new_filename = f"{match.group(1)}_{problem_title}.java"
                old_path = os.path.join(directory, filename)
                new_path = os.path.join(directory, new_filename)
                os.rename(old_path, new_path)
                print(f'Renamed: {filename} -> {new_filename}')

# 현재 스크립트가 실행되는 디렉토리를 기준으로 변경
rename_java_files('c:/vscode/Algo/Baekjoon/Java/')
