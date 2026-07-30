CREATE TABLE interview_template_stage (

                                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

                                          template_id UUID NOT NULL,

                                          type VARCHAR(50) NOT NULL,

                                          name VARCHAR(255) NOT NULL,

                                          description TEXT,

                                          order_number INTEGER NOT NULL,

                                          duration_minutes INTEGER,

                                          created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

                                          CONSTRAINT fk_template_stage_template
                                              FOREIGN KEY(template_id)
                                                  REFERENCES interview_template(id)
);