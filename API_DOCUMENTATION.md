# ClawCode API 文档

## 基础信息
- **服务地址**: `http://101.200.153.89:8090`
- **API 根路径**: `/`
- **数据格式**: JSON

## 接口列表

### 1. Hello 接口
- **路径**: `/hello`
- **方法**: GET
- **描述**: 测试服务连通性
- **请求示例**:
  ```bash
  curl http://101.200.153.89:8090/hello
  ```
- **响应**:
  ```text
  hello world
  ```

### 2. 用户管理接口
- **基础路径**: `/user`
- **获取用户列表**
  - **路径**: `/user/list`
  - **方法**: GET
  - **描述**: 获取所有用户信息
  - **请求示例**:
    ```bash
    curl http://101.200.153.89:8090/user/list
    ```
  - **响应**:
    ```json
    [
      {
        "id": 1,
        "username": "example",
        "email": "user@example.com"
      }
    ]
    ```

### 3. 工作日报接口
- **基础路径**: `/api/work-reports`
- **获取所有日报**
  - **路径**: `/api/work-reports`
  - **方法**: GET
  - **描述**: 获取所有工作日报记录
  - **请求示例**:
    ```bash
    curl http://101.200.153.89:8090/api/work-reports
    ```

- **获取特定日报**
  - **路径**: `/api/work-reports/{id}`
  - **方法**: GET
  - **参数**: 
    - `id` (路径参数): 日报ID
  - **请求示例**:
    ```bash
    curl http://101.200.153.89:8090/api/work-reports/1
    ```

- **创建日报**
  - **路径**: `/api/work-reports`
  - **方法**: POST
  - **请求体**:
    ```json
    {
      "workContent": "完成API文档编写",
      "nextDayPlan": "测试接口功能",
      "completionStatus": "已完成",
      "problems": "无",
      "solutions": "无"
    }
    ```
  - **请求示例**:
    ```bash
    curl -X POST http://101.200.153.89:8090/api/work-reports \
      -H "Content-Type: application/json" \
      -d '{"workContent":"完成API文档编写","nextDayPlan":"测试接口功能","completionStatus":"已完成","problems":"无","solutions":"无"}'
    ```

- **更新日报**
  - **路径**: `/api/work-reports/{id}`
  - **方法**: PUT
  - **参数**: 
    - `id` (路径参数): 日报ID
  - **请求体**: 同创建日报

- **删除日报**
  - **路径**: `/api/work-reports/{id}`
  - **方法**: DELETE
  - **参数**: 
    - `id` (路径参数): 日报ID
  - **请求示例**:
    ```bash
    curl -X DELETE http://101.200.153.89:8090/api/work-reports/1
    ```

## 错误处理
- **404 Not Found**: 请求的资源不存在
- **500 Internal Server Error**: 服务器内部错误

## 注意事项
1. 所有接口均支持跨域请求（CORS）
2. 工作日报创建时会自动设置当前日期
3. 日期格式遵循 ISO 8601 标准（如 `2026-02-22`）