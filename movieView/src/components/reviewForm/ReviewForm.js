import React from 'react';
import {Button, Form} from "react-bootstrap";

const ReviewForm = ({handleSubmit, labelText, revText, defaultValue}) => {
    return (
        <Form>
            <Form.Group className="my-b-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>{labelText}</Form.Label>
                <Form.Control ref={revText} as="textarea" rows={3} defaultValue={defaultValue}/>
            </Form.Group>
            <Button variant="outline-info" onClick={handleSubmit}>Submit</Button>
        </Form>
    );
};

export default ReviewForm;