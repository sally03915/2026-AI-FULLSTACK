import React from 'react';
// Ant Design의 Card, Button, Popconfirm에 Image 컴포넌트를 추가로 import 합니다.
import { Card, Button, Popconfirm, Image, Carousel } from 'antd';
import  Link                        from 'next/link';

export default function PostList({ posts = [], handleEdit, handleDelete }) {

  return (
    <div>
      {/* 게시판리스트 */}
      <h3> 게시글 : {posts?.length || 0} </h3>

      {posts?.map((post, index) => (
        <Card
          key={post.id || index}
          style={{ marginBottom: "10px" }}
          actions={[
            <Button type="link" onClick={() => { handleEdit(post); }}>수정</Button>,
            <Popconfirm
              title="정말 삭제하시겠습니까?"
              onConfirm={() => handleDelete(post.id)}
              okText="예"
              cancelText="아니오"
            >
              <Button type="link">
                삭제
              </Button>
            </Popconfirm>
          ]}
        >   
        {/* 게시글 이미지들  - imageUrls   */}
          {post?.imageUrls  &&  post.imageUrls.length>0  &&(
              <Carousel dots draggable style={{ marginBottom: "15px" }}> 
                {post.imageUrls.map((v , idx)=>(      
                  <div  key={idx}  style={{ textAlign: "center", background: "#f0f2f5" }}>
                    <Image
                      // 이미지 소스 URL 설정  
                      src={`http://localhost:8080/${v}`}
                      alt={`post  image ${idx}`}
                      // 스타일 조정 (카드 너비에 맞춤)
                      style={{ maxWidth: "100%", height: "300px", objectFit: "cover", borderRadius: "8px" }}
                    />
                  </div> 
                ))}
              </Carousel>
          )}

          {/* 게시글 해쉬태그 - hashtags*/}
          { ( post?.hashtags ?? []).length > 0  && (
            <div>
              해쉬태그 : {" "} 
              { post.hashtags.map(( tag , idx)=>(
                <span style={{color:"blue" , marginRight:"8px"}} >
                  #{tag}
                </span>
              ))}
            </div>
          )} 
          {/* 게시글 텍스트 내용 */}
          <p>{post?.content}</p>
        </Card>
      ))}
    </div>
  );
}