// components/EditPostModal
import {Modal , Form , Input , Button , Upload, Select }  from 'antd'; 
export default function   EditPostModal({
    visible, onCancel,  editPost, onSubmit , uploadFiles, setUploadFiles  //  ##4.   uploadFiles, setUploadFiles 
}){ 
   ////////////////////////////////////////
    return(<Modal  title="글 수정"   open={visible}  onCancel={onCancel}  footer={null}  >
        <Form  
            initialValues={{
                content:editPost?.content,
                hashtags: editPost?.hashtags
            }}
            onFinish={onSubmit}
            layout="vertical"
        >
            <Form.Item  name="content"  label="내용">
                <Input.TextArea  rows={4}/>
            </Form.Item>
            {/* 해시태그 입력 */}
            <Form.Item  label="해시태그"   name="hashtags" >
                <Select mode="tags"  style={{width:"100%"}}  placeholder="해시태그 입력 후 Enter"  />
            </Form.Item>
            {/* 이미지 업로드  ##5.  파일변경시 변경되는 값추가 */}
            <Form.Item label="이미지 업로드">
                <Upload
                    multiple
                    beforeUpload={() => false}
                    onChange={({ fileList }) =>
                    setUploadFiles(fileList.map((f) => f.originFileObj))
                    }
                >
                    <Button>이미지 선택</Button>
                </Upload>
            </Form.Item>
            <Button  type="primary"  htmlType="submit">
                수정완료
            </Button>
        </Form>
    </Modal>);
}