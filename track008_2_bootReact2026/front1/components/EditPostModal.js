// components/EditPostModal
import {Modal , Form , Input , Button}  from 'antd';
export default function   EditPostModal({
    visible, onCancel,  editPost, onSubmit
}){
    return(<Modal  title="글 수정"   open={visible}  onCancel={onCancel}  footer={null}  >
        <Form  
            initialValues={{
                content:editPost?.content,
            }}
            onFinish={onSubmit}
            layout="vertical"
        >
            <Form.Item  name="content"  label="내용">
                <Input.TextArea  rows={4}/>
            </Form.Item>
            <Button  type="primary"  htmlType="submit">
                수정완료
            </Button>
        </Form>
    </Modal>);
}