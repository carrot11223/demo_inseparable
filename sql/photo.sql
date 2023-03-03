use photo_inseparable;
create table table_photo
(
    photo_id    tinyint auto_increment comment '图片id'
        primary key,
    key_word    varchar(10240)                     null comment '限制大小为10k,10240个字节，1k = 1024字节（B）',
    photo_url   varchar(512)                       null comment '本地存储图片的url',
    create_time datetime default CURRENT_TIMESTAMP not null comment '图片创建时间'
)
    comment '图片表';