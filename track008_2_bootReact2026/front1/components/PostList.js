import React from 'react';
import { Card , Button, Popconfirm}  from 'antd';
export default function PostList({ posts , handleEdit ,handleDelete }){ 
    /////////////////////////
    return (  <div>
            {/* 게시판리스트 */}    
            <h3> 게시글  : {posts.length} </h3>  
            {posts.map( ( post, index)=>(
                <Card key={post.id || index} 
                      style={{ marginBottom:"10px"}}
                      actions={[
                        <Button type="link" onClick={ ()=>{ handleEdit(post); }} >수정</Button>,
                        <Popconfirm  
                            title="정말 삭제하시겠습니까?"
                            onConfirm={()=> handleDelete(post.id)}
                            okText="예"
                            cancelText="아니오"
                        >
                            <Button type="link">
                                삭제
                            </Button>
                        </Popconfirm>
                    ]}
                >
                    <p>{post.content}</p>
                </Card>
            ))}
        </div> );
}