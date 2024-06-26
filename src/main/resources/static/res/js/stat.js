const mysql = require('mysql2');

// 创建连接
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'login'
});

// 查询示例，使用Promise封装
function queryDatabase(sql, params) {
    return new Promise((resolve, reject) => {
        connection.query(sql, params, (err, rows, fields) => {
            if (err) {
                reject(err);
            } else {
                resolve(rows);
            }
        });
    });
}

const result = null;

// 使用Promise进行查询
queryDatabase('SELECT id,name FROM equipment WHERE category_id = ?', [2])
    .then(rows => {
        console.log(rows); // 输出查询结果
        this.result = rows;
        console.log(2,this.result);
        window.alert(this.result);
    })
    .catch(err => {
        console.error('Error executing query:', err);
    })
    .finally(() => {
        connection.end(); // 关闭连接
    });

