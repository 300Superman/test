
/* 删除 */
drop table t_message;
drop table t_user;

drop sequence sq_message;
drop sequence sq_user;

/* 创建 */
create table t_user(
  u_id number(6) primary key,
  u_userName varchar2(30),
  u_password varchar2(50),
  u_gender number(1),
  u_birthday date,
  u_registeTime date
);
create table t_message(
  m_id number(8) primary key,
  m_title varchar2(30),
  m_content varchar2(500),
  m_userId number(6),
  foreign key(m_userId) references t_user(u_id)
);

create sequence sq_user start with 1001;
create sequence sq_message start with 10000001;

/* 处理序列初始值 */
insert into t_user values(1000, 'admin', '9999', 1, to_date('1986-5-30', 'yyyy-mm-dd'), 
       to_date('2008-10-1 10:10:10', 'yyyy-mm-dd hh24:mi:ss'));
insert into t_message values(10000000, '新系统上线!', 
       '系统1.0几天开始正式上线运行~', 1000);
commit;

/* 添加测试数据 */
insert into t_user values(sq_user.nextval, 'apple', '9999', 1, 
       to_date('1989-6-28', 'yyyy-mm-dd'), 
       to_date('2008-10-1 10:20:10', 'yyyy-mm-dd hh24:mi:ss'));
insert into t_message values(sq_message.nextval, '新系统测试报告', 
       '系统1.0测试结果如下:.....', sq_user.currval);
/* 提交事务 */
commit;

/* 查询语句 */
/*
   select * from t_user order by u_id;
   select * from t_message order by m_id;
*/
