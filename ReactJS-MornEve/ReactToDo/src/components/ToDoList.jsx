import React from 'react'; //, { useState }
import ContentEditable from 'react-contenteditable';

// const ToDoList = (props) => {
function ToDoList(props) {

    return(
    <div className='todo_style'>
        <li className="text-capitalize d-flex justify-content-between my-2">
            {/* <h4 id="container" type="text"
                contentEditable={true}
                suppressContentEditableWarning={true}
                // disabled={!props.editModeEnabled}
                // onChange={onChange}
                // onInput={props.emitChange} 
                // onBlur={props.emitChange}
                // dangerouslySetInnerHTML={{__html: this.props.html}}
                // onChange={props.handleEditClick}
                > 
                {props.text}
            </h4> */}

            <ContentEditable style={ceStyle}
                className="name"
                html={props.text}
            />

            <div className="todo-icon">
                <button className="mx-2 text-success">
                    <i className="fas fa-save" 
                        onClick = {(html) => {
                            props.saveThing(html);
                        }}
                    />
                </button>
                <button className="mx-2 text-danger">
                    <i className="fas fa-trash" 
                        onClick = {() => {
                            props.onDelete(props.id);
                        }}
                    />
                </button>
            </div>
        </li>
    </div>
    );
};

const ceStyle = {
    flex: '7', padding: '5px',margin:"10px",border:"2px solid black",borderRadius:'5px',height:"40px", fontSize:"17px"
    // text-align= right;
    // height: 30px;
    // top: 10px;
    // border: none;
    // background: transparent;
    // font-size: 20px;
    // font-weight: 500;
    // width: 60%;
    // border-bottom: 2px solid;
    // outline: none;
  }
export default ToDoList;